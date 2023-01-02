# PoC Cartes

Ce PoC est un couple Spring Boot / React (Vite) permettant de présenter les usages suivants :
- Vue de la position ISS
- Vue des observations autour d'un emplacement


## Versions
- Node 18 (?)
- Java 17 (?)

## Installation du projet
```
$ make install
```

## Lancement du backend
```
$ gradle bootRun
```

On peut activer le build continu dans un second shell avec cette commande afin de reload l'API à chaque changement de code :
```
$ gradle build --continuous
```
