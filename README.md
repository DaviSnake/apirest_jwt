### Pasos para agregar a contendor podman
- Generar archivo Dockefile
- Generar archivo poman-compose.yml
- Realizar compilación del proyecto
    - ./mvnw clean package
- Copiar fuera de la carpeta del proyeto archivo poodman-compose.ymal
- Generar contenedores en podman
    - podman compose up -d