# OpenJDK 17-es kép
FROM openjdk:17-jdk-alpine

# könyvtár az alkalmazáshoz
WORKDIR /app

# projekt összes fájl másolása a konténerbe
COPY .. .

# Java forrásfájlok fordítása
RUN javac Main_DRY.java

# indítási parancs a Main_DRY osztály futtatására
CMD ["java", "Main_DRY"]
