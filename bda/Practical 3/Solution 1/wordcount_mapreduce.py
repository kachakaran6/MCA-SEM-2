from collections import defaultdict
import multiprocessing


# Mapper function
def mapper(chunk):
    word_count = defaultdict(int)
    for word in chunk.split():
        word_count[word] += 1
    return word_count


# Reducer function
def reducer(results):
    word_count = defaultdict(int)
    for wc in results:
        for word, count in wc.items():
            word_count[word] += count
    return word_count


# MapReduce function
def mapreduce(data, mapper, reducer, num_processes=2):
    with multiprocessing.Pool(processes=num_processes) as pool:
        mapped_data = pool.map(mapper, data)
        reduced_data = reducer(mapped_data)
    return reduced_data


if __name__ == "__main__":
    # Sample input data
    data = ["hello world", "world is beautiful", "hello beautiful world"]

    # Execute MapReduce
    word_counts = mapreduce(data, mapper, reducer)

    # Output results
    print("Word Counts:")
    for word, count in word_counts.items():
        print(f"{word}: {count}")
