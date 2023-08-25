import React, { useState } from 'react';
import TextField from '@mui/material/TextField';

function Test() {
  const [birthDate, setBirthDate] = useState('');

  const handleDateChange = (event) => {
    setBirthDate(event.target.value);
  };

  return (
    <TextField
      label="Data di Nascita"
      fullWidth
      type="date"
      InputLabelProps={{
        shrink: true,
      }}
      InputProps={{
        inputProps: {
          max: new Date().toISOString().split('T')[0], // Impedisci la selezione di date future
        },
        value: birthDate,
        onChange: handleDateChange,
      }}
      required
    />
  );
}

export default Test;
