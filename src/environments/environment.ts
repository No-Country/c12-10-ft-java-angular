// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

// const host = 'http://192.168.1.36:8000/';
/*const host = 'http://192.168.1.36:8000/';*/
const host = 'http://localhost:3000/';
const hostAuth = 'http://';

export const environment = {
    production: false,
    url: host,
    // apiExternalUrl: hostAuth + 'api/v1',
    // apiUrl: host + 'api/v1',
};
