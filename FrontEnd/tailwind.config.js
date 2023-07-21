/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {


    extend: {
      colors: {
        tranparente:'transparent',
        orange: '#e45858',
        white:'#ffff',
        gray100:'#DDDDDD',
        stroke: '#335692'

        },
      spacing   : {
        '0.5': '2px',
        '15': '3.75rem'
      },
    },
  },
  plugins: [],
}

