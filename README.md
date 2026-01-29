# Duplicate-detection-system
duplicate detection using hashing and database

## Overview
This project is designed to detect duplicate entries such as emails or usernames
using hashing techniques. It uses a HashMap to detect duplicates quickly and stores all records 
in a database safely for future use. 

## functions performed 
- Stores data in SQLite database
- uses hashmap for O(1) lookup
- simple command line interface
- detects duplicates efficiently

## Algorithm Used
Hashing is used to generate a hash value for each input record.
All existing hashes are stored in a HashMap, allowing duplicate detection in constant time O(1). 
This approach significantly improves performance compared to linear search.


