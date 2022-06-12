# Richest Backend Service
## Clone the Backend Service
Clone this project
### `git clone https://github.com/topiks/bangkit_capstone_2022.git`
---
Install Node.js
### `npm init`
Install all the dependencies on list in the requirements.txt file
### `npm install "name of dependencies" --save`
Run the backend service
### `npm start`
---
## Deploying on Cloud Run
Create Container Registry
### `gcloud build submit –tags  gcr.io/PROJECT-ID/backend-service`
Deploy using Cloud Run Console on GCP, using default environment, make sure on port 8080





