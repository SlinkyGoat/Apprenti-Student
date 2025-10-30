import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import DndClass from './DndClass'

function App() {
  const classes = [
    'barbarian',
    'bard',
    'cleric',
    'druid',
    'fighter',
    'monk',
    'paladin',
    'ranger',
    'rogue',
    'sorcerer',
    'warlock',
    'wizard'
  ];
  const [selectedClass, setSelectedClass] = useState(classes[0]);
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    setLoading(true);
    setError(null);
    setData(null);
    fetch(`https://www.dnd5eapi.co/api/classes/${selectedClass}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        setData(data);
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }, [selectedClass]);

  const handleChange = (e) => {
    setSelectedClass(e.target.value);
  };

  return (
    <div>
      <label htmlFor="class-select">Choose a D&D class: </label>
      <select id="class-select" value={selectedClass} onChange={handleChange}>
        {classes.map((cls) => (
          <option key={cls} value={cls}>{cls.charAt(0).toUpperCase() + cls.slice(1)}</option>
        ))}
      </select>
      <div style={{ marginTop: '1em' }}>
        {loading && 'Loading...'}
        {error && `Error: ${error.message}`}
        <DndClass data={data} />
      </div>
    </div>
  );
}

export default App
