import quad, utils
from fb import db as dbreference
import time

query_range = 0.07207 / 4


def get_nearby(qt, lat, long):
    cell = quad.cell(abs(lat), abs(long), query_range, query_range)
    results = qt.query(cell)
    return [result.to_dict() for result in results]

def enroute(qt,lat1, long1, lat2, long2):
    # distance = utils.distance(lat1, long1, lat2, long2)
    # print(distance)
    cell = quad.cell(abs(lat1), abs(long1), abs(lat2-lat1), abs(long2-long1))
    print(cell)
    results = qt.query(cell)
    print(len(results))
    return [result.to_dict() for result in results]

def mark_crime(qt, lat, long, crime):
    utils.insert_to_qt(qt, lat, long, crime)

    dbreference.child('crime').push(
        {'crime':crime,'latitude':lat, 'longitude':long}
        )

    # with open('data.csv', 'a+') as file:
    #     with csv.writer(file) as csvwriter:
    #         csvwriter.write_row((lat, long, crime,))

def send_sos(sos_qt, lat, long, phone):
    cell = quad.cell(abs(lat), abs(long), query_range, query_range)
    results = sos_qt.query(cell)

    mark_sos([result.email for result in results], lat, long, phone)

def mark_sos(locations, lat, long, phone):
    for location in locations:
        location = location.replace('@','%').replace('.','%')

        time_ref = int(time.time())

        dbreference.child('sos_location').child(location).child('sos').child(time_ref).child({'lat':lat, 'long':long, 'timestamp':time_ref, 'phone':phone})

def create_sos_location(sos_qt, lat, long, email):
    utils.insert_to_sos_qt(sos_qt, lat, long, email)
