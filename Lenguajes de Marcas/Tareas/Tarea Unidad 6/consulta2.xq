(:Ejercicio 2: Obtener el número de puertos de España.:)

for $i in doc("puertos.xml")/puertos
let $c :=  $i/puerto[pais='España']
return <NumeroDePuertosEnEspaña>{count($c)}</NumeroDePuertosEnEspaña>