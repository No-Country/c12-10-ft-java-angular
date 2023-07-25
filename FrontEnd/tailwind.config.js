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
  fontSize: {
    'xs'  : '0.625rem',
    'sm'  : '0.75rem',
    'md'  : '0.8125rem',
    'base': '0.875rem',
    'lg'  : '1rem',
    'xl'  : '1.125rem',
    '2xl' : '1.25rem',
    '2.5xl': '1.375rem',
    '3xl' : '1.5rem',
    '4xl' : '2rem',
    '5xl' : '2.25rem',
    '6xl' : '2.5rem',
    '7xl' : '3rem',
    '8xl' : '4rem',
    '9xl' : '6rem',
    '10xl': '8rem',

},
    extend: {
      colors: {
        tranparente:'transparent',
        orange: '#e45858',
        white:'#ffff',
        gray100:'#DDDDDD',
        stroke: '#335692',
        antiflashwhite: '#F3F7F8',
        gianOrange: '#FF682C',
        blac300: '#323232',
        black200: '#34373B',
        Black500: '#1E2022',
        black400: '#292524',
        blue200: '#3D5A80',
        orange200: '#F59E0B',
        black100 : '#9CA3AF',
        black600: '#222222',
        orange100: '#ffecc9',
        black50: '#EDEDED'

        },
      spacing   : {
        '0.5': '2px',
        '15': '3.75rem'
      },

      width: {
        '560': '35rem',
        '300': '18.75rem',
        '310': '19.375rem',
        '327': '20.438rem',
      },
      height:{
        '310': '19.375rem',
      }
    },
  },
  plugins: [],
}

