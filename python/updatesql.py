import pymysql.cursors


etemp_max=1 
etemp_min=1 
esoli_max=1 
esoil_min=1 
ehummidity=1

# Connect to the database
db = pymysql.connect(host='localhost',
                             user='root',
                             password='987978',
                             db='mysql',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)
cursor = db.cursor()
sql="UPDATE DB.datacontrol SET temp_max =50, temp_min=30  WHERE id=1"

try:

   cursor.execute(sql)

   db.commit()
except:

   db.rollback()
db.close()
