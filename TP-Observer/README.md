##Ejercicio 1:

###Patrón Observer
- Subject: Subject
- ConcreteSubject: RepositorioPublicaciones
- Observer: Observer
- ConcreteObserver: MiembroLaboratorio

###Patrón Composite

- Cliente: MiembroLaboratorio
- Component: FiltroIntereses 
- Leaf: FiltroPorFiliacion, FiltroPorTitulo, FiltroPorLugarPublicacion, FiltroPorPalabraClave, FiltroPorConferencia, FiltroPorTipoArticulo, FiltroPorAutor
- Composite: FiltroAnd, FiltroOr 

---
##Ejercicio 2:

###Patrón Observer
- Subject: Subject
- Observer: Observer
- ConcreteSubject: EncuentrosDeportivos
- ConcreteObserver: AplicacionMovil
- ConcreteObserver: Servidor
