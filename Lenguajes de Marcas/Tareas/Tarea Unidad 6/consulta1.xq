(:Ejercicio 1: Obtener el nombre de los puertos de Italia.:)

for $i in doc("puertos.xml")/puertos/puerto where $i/pais='Italia' 
return <puerto>{$i/nombre}</puerto>