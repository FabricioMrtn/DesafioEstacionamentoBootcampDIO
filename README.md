# DesafioEstacionamentoBootcampDIO

## Run Database

docker run --name parking-app -p 5433:5433 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:14-alpine