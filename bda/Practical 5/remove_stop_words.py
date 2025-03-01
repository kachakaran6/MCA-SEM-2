def load_stop_words(stopwords_file):
    """Load stop words from a file into a set"""
    with open(stopwords_file, "r", encoding="utf-8") as file:
        stop_words = {line.strip().lower() for line in file}
    return stop_words


def remove_stop_words(input_file, stopwords_file, output_file):
    """Remove stop words from each line of the input file"""
    stop_words = load_stop_words(stopwords_file)

    with open(input_file, "r", encoding="utf-8") as infile, open(
        output_file, "w", encoding="utf-8"
    ) as outfile:
        for line in infile:
            filtered_words = [
                word for word in line.split() if word.lower() not in stop_words
            ]
            outfile.write(" ".join(filtered_words) + "\n")


if __name__ == "__main__":
    input_file = "input.txt"  # Large text file (one sentence per line)
    stopwords_file = "stopwords.txt"  # Stop words file (one per line)
    output_file = "output.txt"  # Processed file without stop words

    remove_stop_words(input_file, stopwords_file, output_file)
    print("Stop word elimination complete. Processed output saved in", output_file)
