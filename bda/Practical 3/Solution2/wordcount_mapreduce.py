from collections import defaultdict
from multiprocessing import Pool


# Mapper function
def mapper(text):
    word_count = defaultdict(int)
    for word in text.split():
        word_count[word.lower()] += 1
    return word_count


# Reducer function
def reducer(count_dicts):
    word_count = defaultdict(int)
    for count_dict in count_dicts:
        for word, count in count_dict.items():
            word_count[word] += count
    return word_count


# Main function to orchestrate MapReduce process
def main():
    # Sample input data
    data = ["Hello world", "World is beautiful", "Hello beautiful world"]

    # Map phase
    with Pool() as pool:
        mapped_data = pool.map(mapper, data)

    # Reduce phase
    reduced_result = reducer(mapped_data)

    # Print the final word counts
    print("Word Counts:")
    for word, count in reduced_result.items():
        print(f"{word}: {count}")


if __name__ == "__main__":
    main()
