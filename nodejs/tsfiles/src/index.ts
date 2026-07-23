import { promises as fs } from "fs";
import path from "path";

async function main() {
    const filePath = path.join(__dirname, "..", "output.txt");

    // Lines to write
    const lines = [
        "First line",
        "Second line",
        "Third line",
        "Fourth line"
    ];

    // Write file
    await fs.writeFile(filePath, lines.join("\n"), "utf8");

    console.log("File written.");

    // Read file
    const content = await fs.readFile(filePath, "utf8");

    console.log("\nContents:");

    for (const line of content.split(/\r?\n/)) {
        console.log(line);
    }
}

main().catch(console.error);