from mrjob.job import MRJob
from mrjob.step import MRStep


class WeatherDataStats(MRJob):

    def mapper(self, _, line):
        """Tokenizes each line and emits (word, 1)"""
        fields = line.split(",")
        if len(fields) == 3:
            # Extract year and temperature from the line
            year = fields[0].strip()
            temperature = float(fields[1].strip())
            yield year, temperature

    def reducer(self, year, temperatures):
        """Aggregates counts for each word"""
        temperatures = list(temperatures)
        avg_temp = sum(temperatures) / len(temperatures)
        max_temp = max(temperatures)
        min_temp = min(temperatures)
        yield year, (avg_temp, max_temp, min_temp)


class FilterTemperature(MRJob):

    def mapper(self, _, line):
        """Filters the data with temperature > 30"""
        fields = line.split(",")
        if len(fields) == 3:
            # Extract year, temperature, and other data
            year = fields[0].strip()
            temperature = float(fields[1].strip())
            other_data = fields[2].strip()

            # Yield the temperature if it's greater than 30
            if temperature > 30.0:
                yield year, (temperature, other_data)

    def reducer(self, year, readings):
        """Writes the filtered readings to a file"""
        with open(f"filtered_readings_{year}.txt", "w") as f:
            for reading in readings:
                f.write(f"{year}, {reading[0]}, {reading[1]}\n")


if __name__ == "__main__":
    # Configure the job to run with the local runner
    import sys

    if len(sys.argv) < 2:
        sys.argv.append("ncdc_data.txt")  # Provide your input file path here

    WeatherDataStats.run()
    FilterTemperature.run()
