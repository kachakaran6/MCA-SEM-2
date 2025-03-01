from mrjob.job import MRJob
from mrjob.step import MRStep


class WordCount(MRJob):

    def steps(self):
        return [MRStep(mapper=self.mapper, reducer=self.reducer)]

    def mapper(self, _, line):
        """Tokenizes each line and emits (word, 1)"""
        for word in line.split():
            yield word.lower(), 1

    def reducer(self, word, counts):
        """Aggregates counts for each word"""
        yield word, sum(counts)


if __name__ == "__main__":
    WordCount.run()
