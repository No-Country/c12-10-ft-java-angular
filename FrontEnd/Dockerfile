# Stage 1: Build the Angular app
FROM node:20-alpine AS builder

WORKDIR /usr/local/app

# Copy the package.json and package-lock.json files to the working directory
COPY ./ /usr/local/app/

# Install the dependencies
RUN npm install

# # Copy the entire Angular project to the working directory
COPY . .

# Build the Angular app
RUN npm run build

# Stage 2: Serve the built app using Nginx
FROM nginx:1.21

# Remove the default Nginx website
RUN rm -rf /usr/share/nginx/html/*

# Copy the built Angular app from the previous stage to the Nginx web server directory
COPY --from=builder /usr/local/app/dist/c12-10-ft-angular /usr/share/nginx/html/

# Expose the default Nginx port (80)
EXPOSE 80

# Start Nginx when the container starts
CMD ["nginx", "-g", "daemon off;"]