# Richest Frontend Service
## Clone the Backend Service
Clone this project
### `git clone https://github.com/topiks/bangkit_capstone_2022.git`
---
Install all the dependencies on list in the requirements.txt file
### `npm install "name of dependencies" --save`
Run the backend service
### `npm start`
---
## Deploying on App Engine
Run `npm run build` to make build folder for deploying react.js app
###
Create Storage Bucket, upload the build folder and app.yaml file
### 
Create new directory on GCP “mkdir richest-app”
### 
push 
### `gcloud build submit –tags  gcr.io/PROJECT-ID/backend-service`
Deploy using Cloud Run Console on GCP, using default environment, make sure on port 8080
