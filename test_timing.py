from timing_decorator import timing_decorator
import time
import random

@timing_decorator
def sample_function(n):
    """A sample function that sleeps for a random time."""
    sleep_time = random.uniform(0.1, 0.5)
    time.sleep(sleep_time)
    return f"Slept for {sleep_time:.2f} seconds"

if __name__ == "__main__":
    result = sample_function(100)
    print(result)