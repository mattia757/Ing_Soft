import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Button from '@mui/material/Button';

export default function ControlledOpenSelect() {
  const [open, setOpen] = React.useState(false);
  const [gender, setGender] = React.useState('');
  
  const handleChange = (event) => {
    setGender(event.target.value);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    setOpen(true);
  };

  return (
    <div>
      <FormControl sx={{ m: 1, minWidth: 120 }}>
        <InputLabel id="demo-controlled-open-select-label">Gender</InputLabel>
        <Select
          labelId="demo-controlled-open-select-label"
          id="demo-controlled-open-select"
          open={open}
          onClose={handleClose}
          onOpen={handleOpen}
          value={gender}
          label="Gender"
          onChange={handleChange}
        >
          <MenuItem value={'maschio'}>maschio</MenuItem>
          <MenuItem value={'femmina'}>femmina</MenuItem>
        </Select>
      </FormControl>
    </div>
  );
}
