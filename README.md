# Holiday-Planner

2 tipuri de utilizatori: admin si cititor

Aplicatia dispune de o pagina de register (cine se inregistreaza este defapt de tip admin, clientul 
se poate loga si atat ceea ce inseamna ca adminul trebuie sa adauge cititori) si una de login (cu user si parola) accesibila oricui.
Userul Admin dupa logare are posibilitatea de a:
- crea utilizatori noi de tip cititori (username, email, nume, prenume)
- adauga noi categorii de carti
- adauga carti noi in categoriile din librarie (nume, descriere, pret, nr pagini)
- vede categoriile deja existente
- vede comenzi neprocesate.
- vede istoric comenzi

Un cititor dupa logare poate sa:
- vada orice produs din orice categorie sau pe categorii.(la afisarea cartii se afiseaza toate informatiile despre aceasta)
- comande o carte prin specificarea cantitatii. 
- sa vada cosul curent si lista cu fiecare carte si ce cantitate plus suma per carte
  (daca a comandat 2 carti de 1 leu o sa vada 2xCarte = 2 Lei precum si suma totala a comenzii)
- sa plaseze o comanda.

In momentul plasarii comenzii orice admin poate vedea comenziile neprocesate in meniul Comenzi neprocesate 
si le poate marca ca si procesat.
