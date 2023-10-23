FROM gradle:8.2.0-jdk17
#CMD ls
WORKDIR /db
##CMD echo "hello"
COPY . .
##CMD bash
CMD ./gradlew generateMigration
RUN apt-get update && apt-get install make
RUN make mig
##EXPOSE 5432
RUN make ins
CMD make start

#CMD bash




