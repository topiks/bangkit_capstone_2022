# Richest Frontend Service
## Getting Started with Create ReactJS
ReactJS offers graceful solutions to some of front-end programming’s most persistent issues, allowing you to build dynamic and interactive web apps with ease. It’s fast, scalable, flexible, powerful, and has a robust developer community that’s rapidly growing. There’s never been a better time to learn React
###
This frontend service use ReactJS to develop the website
###
to create the ReactJS, run `npx create-react-app "name of the project"`
---

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
Push the bucket into the directory `gsutil rsync /name.bucket ./richest-app`
### 
Deploy
### `gcloud app deploy`
