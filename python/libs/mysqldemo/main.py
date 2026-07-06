import mysql.connector
import getpass


def doThings(cnx):
    cur = cnx.cursor()

    cur.execute("SELECT CURDATE()")
    row = cur.fetchone()
    print(cur)
    print("Current date is: {0}".format(row[0]))

    cur.execute("use sakila")
    cur.execute("select * from actor")
    row = cur.fetchone()
    print("Row: ", row)


if __name__ == '__main__':
    # password = getpass.getpass("Password: ")
    password = input("Password: ")

    cnx = mysql.connector.connect(host="127.0.0.1", port=3306, user="root", password=password)

    doThings(cnx)

    cnx.close()