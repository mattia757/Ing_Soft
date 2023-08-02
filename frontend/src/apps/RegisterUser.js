import React, { useState, useEffect } from 'react';
import {
  Button,
  Checkbox,
  Container,
  Grid,
  InputLabel,
  Paper,
  Select,
  TextField,
  Typography,
  FormControl,
  FormControlLabel,
  MenuItem,
} from '@mui/material';
import styled from '@mui/material/styles/styled';

const StyledPaper = styled(Paper)(({ theme }) => ({
  padding: theme.spacing(3),
  maxWidth: '600px',
  margin: 'auto',
  marginTop: theme.spacing(3),
}));

const StyledForm = styled('form')(({ theme }) => ({
  '& .MuiTextField-root': {
    marginBottom: theme.spacing(2),
  },
  '& .MuiButton-root': {
    marginTop: theme.spacing(2),
  },
}));

function RegistrationForm() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [gender, setGender] = useState('');
  const [open, setOpen] = React.useState(false);
  const [birthDate, setBirthDate] = useState('');
  const [birthPlace, setBirthPlace] = useState('');
  const [birthCountry, setBirthCountry] = useState('');
  const [educationTitle, setEducationTitle] = useState('');
  const [email, setEmail] = useState('');
  const [isStudent, setIsStudent] = useState(false);

  const [isFormComplete, setIsFormComplete] = useState(false);

  const isEmailValid = (email) => {
    // Regular expression for basic email validation
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailPattern.test(email);
  };

  const isBirthDateValid = (birthDate) => {
    const currentDate = new Date();
    const minDate = new Date(1920, 0, 1); // 1 gennaio 1920
    const maxDate = new Date(currentDate.getFullYear() - 18, currentDate.getMonth(), currentDate.getDate());
  
    const inputDate = new Date(birthDate);
    return inputDate >= minDate && inputDate <= maxDate;
  
  }

  const isNameValid = (name) => {
    const namePattern = /^[a-zA-Z\s]*$/;
    return namePattern.test(name);
  };

  useEffect(() => {
    if (
      firstName &&
      lastName &&
      isNameValid(firstName) &&
      isNameValid(lastName) &&
      gender &&
      birthDate &&
      isBirthDateValid(birthDate) &&
      birthPlace &&
      birthCountry &&
      educationTitle &&
      email &&
      isEmailValid(email)
    ) {
      setIsFormComplete(true);
    } else {
      setIsFormComplete(false);
    }
  }, [firstName, lastName, gender, birthDate, birthPlace, birthCountry, educationTitle, email]);


  const handleSubmit = (event) => {
    event.preventDefault();

    if (
      firstName &&
      lastName &&
      isNameValid(firstName) &&
      isNameValid(lastName) &&
      gender &&
      birthDate &&
      birthPlace &&
      birthCountry &&
      educationTitle &&
      email &&
      isEmailValid(email)
    ) {
      setIsFormComplete(true);
      const formData = {
        firstName,
        lastName,
        gender,
        birthDate,
        birthPlace,
        birthCountry,
        educationTitle,
        email,
        isStudent,
      };
      console.log(formData);
    } else {
      setIsFormComplete(false);
    }
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    setOpen(true);
  };

  return (
    <Container maxWidth="md">
      <StyledPaper>
        <Typography variant="h5" gutterBottom>
          Registration Form
        </Typography>
        <StyledForm onSubmit={handleSubmit}>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <TextField
                label="Nome"
                fullWidth
                name="firstName"
                value={firstName}
                onChange={(event) => setFirstName(event.target.value)}
                required
                error={!isNameValid(firstName)}
                helperText={
                  !isNameValid(firstName) ? 'Inserisci un nome valido' : ''
                }
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                label="Cognome"
                fullWidth
                name="lastName"
                value={lastName}
                onChange={(event) => setLastName(event.target.value)}
                required
                error={!isNameValid(lastName)}
                helperText={
                  !isNameValid(lastName) ? 'Inserisci un cognome valido' : ''
                }
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                label="Data di Nascita"
                fullWidth
                type="date"
                name="birthDate"
                value={birthDate}
                onChange={(event) => setBirthDate(event.target.value)}
                required            
              />
            </Grid>
            </Grid>
            <Grid item xs={12}>
              <TextField
                label="Luogo di Nascita"
                fullWidth
                name="birthPlace"
                value={birthPlace}
                onChange={(event) => setBirthPlace(event.target.value)}
                required
                inputProps={{
                  min: '1920-01-01', // Imposta la data minima
                }}            
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                label="Stato di Nascita"
                fullWidth
                name="birthCountry"
                value={birthCountry}
                onChange={(event) => setBirthCountry(event.target.value)}
                required
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                label="Titolo di Studio"
                fullWidth
                name="educationTitle"
                value={educationTitle}
                onChange={(event) => setEducationTitle(event.target.value)}
                required
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                label="Email"
                fullWidth
                type="email"
                name="email"
                value={email}
                onChange={(event) => setEmail(event.target.value)}
                required
                error={!isEmailValid(email) && email.trim() !== ''}
                helperText={
                  !isEmailValid(email) && email.trim() !== ''
                    ? 'Inserisci un indirizzo email valido'
                    : ''
                }
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <FormControl sx={{ m: 1, minWidth: 120 }}>
                <InputLabel id="demo-controlled-open-select-label">
                  Gender
                </InputLabel>
                <Select
                  labelId="demo-controlled-open-select-label"
                  id="demo-controlled-open-select"
                  open={open}
                  onClose={handleClose}
                  onOpen={handleOpen}
                  name="gender"
                  value={gender}
                  label="Gender"
                  onChange={(event) => setGender(event.target.value)}
                  required
                >
                  <MenuItem value={'maschio'}>Maschio</MenuItem>
                  <MenuItem value={'femmina'}>Femmina</MenuItem>
                </Select>
              </FormControl>
            <Grid item xs={12}>
              <FormControlLabel
                control={
                  <Checkbox
                    name="isStudent"
                    checked={isStudent}
                    onChange={(event) => setIsStudent(event.target.checked)}
                  />
                }
                label="Studente"
              />
            </Grid>
            <Grid item xs={12}>
              <Button
                type="submit"
                variant="contained"
                color="primary"
                disabled={!isFormComplete}
              >
                Registrati
              </Button>
            </Grid>
          </Grid>
        </StyledForm>
      </StyledPaper>
    </Container>
  );
}

export default RegistrationForm;
