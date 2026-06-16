import time
from concurrent.futures import ThreadPoolExecutor, as_completed

def task(name, delay):
    print(f"{name} started (delay={delay})")
    time.sleep(delay)
    return f"{name} finished (delay={delay})"

def allCompleted():
    with ThreadPoolExecutor() as executor:
        futures = [
            executor.submit(task, "A", 2),
            executor.submit(task, "B", 1),
            executor.submit(task, "C", 3),
        ]
        print("futures created")
        results = [future.result() for future in futures]
    print(results)

def asCompleted():
    with ThreadPoolExecutor() as executor:
        futures = [
            executor.submit(task, "A", 2),
            executor.submit(task, "B", 1),
            executor.submit(task, "C", 3),
        ]
        print("futures created")
        for future in as_completed(futures):
            print(future.result())


if __name__ == '__main__':
    # allCompleted()
    asCompleted()