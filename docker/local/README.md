# development on local machine

## Using docker-compose to config startup environment

please install docker and docker-compose first : https://docs.docker.com/compose/install/

#### Running environment start up

1. Access the docker folder (`cd docker`)
2. launch the environment by docker compose (`docker-compose up -d`)
3. access mysql as you want
4. if there is conflict on port, just modify the corresponding port defined in docker-compose.yml and then launch docker compose again(`docker-compose up -d`)
5. if you want to stop the environment, use command `docker-compose down`
