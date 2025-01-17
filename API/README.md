
# API Documentation

URL: https://sihapi.psproject.repl.co/

## To run

1. Clone the repo

`git clone https://github.com/prashantsengar/BC74_InsertACoolNameHere.git`

2. `cd BC74_InsertACoolNameHere/API`

3. Install requirements

`pip3 install -r requirements.txt`

4. Run the flask server

`python3 main.py`

It will run on `0.0.0.0:1234`

All the API endpoints take arguments lat & long. `lat` here means latitude and `long` means longitude. Similarly, `lat1`, `long1` and `lat2`,`long2` denote a pair of co-ordinates.
### Make sure that Lattitude(lat) and Longitude(long) are in the following range(Range for India)
    North: 35.674521°N 76.844485
    South: 6.74678°N 93.84260
    East: 28.01168°N 97.39564
    West: 23.6261°N 68.1941

## Endpoints

* /nearby - Get all the nearby unsafe areas

Example URL: `/nearby?lat=LATITUDE&long=LONGITUDE`

* /routes - Find unsafe areas between two points

Example URL: `/routes?lat1=LATITUDE&long1=LONGITUDE&lat2=LATITUDE&long2=LONGITUDE`

* /sos - Send SOS at the current location

Example URL: `/sos?lat=LATITUDE&long=LONGITUDE&phone=PHONE_NUMBER`

* /crime - Mark a crime that occured at current location

Example URL: `/crime?lat=LATITUDE&long=LONGITUDE`

* /register - Register a new hospital or police station

Example URL: `/register?lat=LATITUDE&long=LONGITUDE&email=EMAIL`
