import pandas as pd
import multiprocessing
from collections import defaultdict


def mapper(data):
    word_count = defaultdict(int)
    for row in data.itertuples():
        for word in str(
            row.Text
        ).split():  # Assuming the 'text' column contains the text data
            word_count[word] += 1
    return word_count


def reducer(word_counts):
    final_word_count = defaultdict(int)
    for word_count in word_counts:
        for word, count in word_count.items():
            final_word_count[word] += count
    return final_word_count


def mapreduce(data, num_workers=2):
    pool = multiprocessing.Pool(processes=num_workers)
    chunk_size = len(data) // num_workers
    chunks = [data[i : i + chunk_size] for i in range(0, len(data), chunk_size)]
    word_counts = pool.map(mapper, chunks)
    final_word_count = reducer(word_counts)
    pool.close()
    pool.join()
    return final_word_count


if __name__ == "__main__":
    # Ensure to provide the correct path to your Excel file
    df = pd.read_excel(
        "C:/Users/karan/Downloads/BDA1_pracsolution/my_data.xlsx"
    )  # Replace with the actual path
    result = mapreduce(df, num_workers=2)
    print(result)
