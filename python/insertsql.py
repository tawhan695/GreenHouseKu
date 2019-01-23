import pymysql.cursors
# Connect to the database
connection = pymysql.connect(host='localhost',
                             user='root',
                             password='987978',
                             db='mysql',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)
sql = "INSERT INTO DB.data(date,fan,light,pump,temp_in,temp_out,humidity_in,huminity_out,soil)
	VALUES(NOW(),1,1,1,50,60,70,80,90);"

try:
   # Execute the SQL command
   cursor.execute(sql)
   # Commit your changes in the database
   db.commit()
except:
   # Rollback in case there is any error
   db.rollback()

# disconnect from server
db.close()