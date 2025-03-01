import multiprocessing


class MapReduce:
    def __init__(self, num_processes=2):
        self.num_processes = num_processes

    def mapper(self, data):
        raise NotImplementedError("Subclasses must implement mapper method")

    def reducer(self, data):
        raise NotImplementedError("Subclasses must implement reducer method")

    def _map(self, data):
        # Ensure we are applying the mapper to a list of (key, value) tuples
        result = []
        for item in data:
            result.extend(
                self.mapper(item)
            )  # Ensure mapping generates a list of tuples
        return result

    def _reduce(self, data):
        reduced_data = {}
        for key, value in data:
            reduced_data.setdefault(key, []).append(value)
        return [(key, sum(values)) for key, values in reduced_data.items()]

    def run(self, data):
        pool = multiprocessing.Pool(processes=self.num_processes)
        # Split the data into chunks based on the number of processes
        chunk_size = len(data) // self.num_processes
        chunks = [data[i : i + chunk_size] for i in range(0, len(data), chunk_size)]
        mapped_data = pool.map(self._map, chunks)  # Mapping phase
        flattened_data = [
            item for sublist in mapped_data for item in sublist
        ]  # Flatten list of lists
        result = self._reduce(flattened_data)  # Reducing phase
        pool.close()
        pool.join()
        return result


# Example usage:
class WordCount(MapReduce):
    def mapper(self, data):
        key, value = data  # Unpack the (key, value) tuple
        result = []
        for word in value.split():
            result.append((word, 1))  # Collecting words with a count of 1
        return result

    def reducer(self, data):
        key, values = data  # Aggregate the values (sum the counts)
        return (key, sum(values))  # Summing up counts for each word


if __name__ == "__main__":
    # Input data: each tuple contains an ID and a string
    input_data = [(1, "apple banana"), (2, "banana orange"), (3, "orange apple")]

    # Create a WordCount MapReduce job
    word_count_job = WordCount()

    # Run the MapReduce job
    result = word_count_job.run(input_data)

    # Output the result
    for item in result:
        print(item)
