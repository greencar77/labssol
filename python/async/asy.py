import asyncio

async def task(name, delay):
    print(f"{name} started (delay={delay})")
    await asyncio.sleep(delay)
    return f"{name} finished (delay={delay})"

async def main():
    results = await asyncio.gather(
        task("A", 2),
        task("B", 10),
        task("C", 3)
    )
    print(results)

if __name__ == '__main__':
    print("Starting")
    asyncio.run(main())
    print("Finished")