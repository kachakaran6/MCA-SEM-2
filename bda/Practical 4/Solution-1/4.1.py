import multiprocessing


def mapper(data):
    # Mapper function: takes input data and emits key-value pairs
    key, value = data
    result = []
    # Example: Splitting a sentence into words and emitting (word, 1) pairs
    for word in value.split():
        result.append((word, 1))
    return result


def reducer(data):
    # Reducer function: takes key-value pairs and aggregates values by key
    key, values = data
    # Example: Summing up counts for each word
    return (key, sum(values))


def mapreduce(data, mapper, reducer, num_processes=2):
    # Initialize multiprocessing pool
    pool = multiprocessing.Pool(processes=num_processes)

    # Map phase: apply mapper function to data
    mapped_data = pool.map(mapper, data)

    # Flatten mapped data
    flattened_data = [item for sublist in mapped_data for item in sublist]

    # Group mapped data by key
    grouped_data = {}
    for key, value in flattened_data:
        grouped_data.setdefault(key, []).append(value)

    # Prepare data for the reducer
    grouped_data_items = list(grouped_data.items())

    # Reduce phase: apply reducer function to grouped data
    reduced_data = pool.map(reducer, grouped_data_items)

    # Close the pool
    pool.close()
    pool.join()

    return reduced_data


if __name__ == "__main__":
    # Example input data
    input_data = [(1, "apple banana"), (2, "banana orange"), (3, "orange apple")]

    # Perform MapReduce
    result = mapreduce(input_data, mapper, reducer)

    # Output the result
    for item in result:
        print(item)
