# File Compressor Using Run-Length Encoding (RLE) Compression Algorithm

This project implements the **Run-Length Encoding (RLE)** compression algorithm in Java. RLE is a simple, lossless data compression technique used to reduce the size of data by representing consecutive repeated characters with a single character and its count.

## Features

- **Compression**: Compresses a file by replacing consecutive repeating characters with the character and the count of its occurrences.
- **Decompression**: Decompresses a file back to its original form by expanding the compressed data.

## How It Works

### Compression:
- The algorithm scans through the input data and counts consecutive repeating characters.
- Replaces sequences of repeated characters with the character itself followed by the count of repetitions.
  - Example: `"AAAABBBCCDAA"` → `"4A3B2C1D2A"`
- Time Complexity : O(N), n is length of the input file.
- Space Complexity : Depends on Input file(consist of repeating, random or always unique character).

### Decompression:
- The algorithm reads the compressed data and expands each character according to its count, restoring the original data.
  - Example: `"4A3B2C1D2A"` → `"AAAABBBCCDAA"`
- Time Complexity : O(N), n is length of the input file.
- Space Complexity : Depends on Output file(consist of repeating, random or always unique character).

## Requirements

- Java 8 or higher

## File Size Reduction
- Maximum size reduction: Can reach up to 80-90% if the data is highly repetitive.
- Worst case: In the absence of repetition, the size may increase.
- Average case: RLE typically reduces the size by 20-40% in cases with moderate repetition.

## How to Use

### 1. Clone the repository

```bash
git clone https://github.com/Shiv-61/File-Compressor.git
```
### 2. Compile the code
```bash
javac File_compressor.java
```
### 3. Run the code
```bash
java File_compressor
