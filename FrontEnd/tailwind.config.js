/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    screens : {
      print: {'raw': 'print'},
      xs   :'400px',
      sm   : '768px',
      md   : '744px',
      lg   : '1024px',
      xl   : '1280px'
  },
    extend: {
      colors: {
        tranparente:'transparent',
        orange: '#e45858',
        white:'#ffff',
        gray100:'#DDDDDD',
        stroke: '#335692',
        antiflashwhite: '#F3F7F8',

        },
      spacing   : {
        '0.5': '2px',
        '15': '3.75rem'
      },
    },
  },
  plugins: [],
}

