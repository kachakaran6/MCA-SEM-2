from mrjob.job import MRJob


class WordCount(MRJob):
    def mapper(self, _, line):
        # Split the line into words
        words = line.split()
        for word in words:
            yield word, 1

    def reducer(self, word, counts):
        # Sum the counts for each word
        yield word, sum(counts)


if __name__ == "__main__":
    WordCount.run()
