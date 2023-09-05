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

import './css/style.css'
import styled from '@mui/material/styles/styled';

const StyledPaper = styled(Paper)(({ theme }) => ({
    padding: theme.spacing(6),
    //maxWidth: '600px',
    margin: '2rem',
    //marginTop: theme.spacing(3),
    backgroundColor: '#f5f5f5',
    borderRadius: '8px',
    boxShadow: '0px 4px 8px rgba(0, 0, 0, 0.1)',
  }));
  
  const StyledForm = styled('form')(({ theme }) => ({
    '& .MuiTextField-root': {
      //marginBottom: theme.spacing(2),
    },
    '& .MuiButton-root': {
      //marginTop: theme.spacing(2),
    },
  }));

const AnagraficaSection = ({ currentSection, onSubmit }) => {

  //Dati Anagrafici
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
    return namePattern.test(name)
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
            isEmailValid(email) &&
            typeof isStudent === 'boolean'
        ) {
        setIsFormComplete(true);
        } else {
        setIsFormComplete(false);
        }
    }, [firstName, lastName, gender, birthDate, birthPlace, birthCountry, educationTitle, email, isStudent
]);

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
        isEmailValid(email) &&
        typeof isStudent === 'boolean'
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
                isStudent
            };
            console.log(formData);
            onSubmit();
          } else {
            setIsFormComplete(false);
          }
    };

    //Close Select Gender
    const handleClose = () => {
        setOpen(false);
    };

    //Open Select Gender
    const handleOpen = () => {
        setOpen(true);
    };

    return (
        <Container maxWidth="md">
          <StyledPaper>
            <Typography variant="h6" gutterBottom>
              Dati personali
            </Typography>
            <br></br>
            <StyledForm onSubmit={handleSubmit}>
              <Grid container spacing={2}>
                <Grid item xs={12} sm={4}>
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
                <Grid item xs={12} sm={4}>
                  <TextField
                    label="Cognome"
                    fullWidth
                    name="lastName"
                    value={lastName}
                    onChange={(event) => setLastName(event.target.value)}
                    required
                    error={!isNameValid(lastName)}
                    helperText={
                      !isNameValid(lastName) ? 'Inserisci un cognome valido' : ' '
                    }
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <FormControl sx={{ fullWidth: true, mb: 2 }}>
                    <InputLabel id="demo-controlled-open-select-label" >
                      Gender
                    </InputLabel>
                      <Select
                        labelId="demo-controlled-open-select-label"
                        id="demo-controlled-open-select"
                        fullWidth
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
                </Grid>
                <Grid item xs={12} sm={4}>
                  <TextField
                    label="Data di Nascita"
                    fullWidth
                    type="date"                   
                    error={!isBirthDateValid(birthDate)}
                    helperText={
                      !isBirthDateValid(birthDate) ? 'Inserisci una data valida' : ' '
                    }
                    required
                    InputLabelProps={{
                        shrink: true,
                      }}
                      InputProps={{
                        inputProps: {
                          max: new Date().toISOString().split('T')[0],
                        },
                        value: birthDate, // This will control the value of the input
                        onChange: (event) => setBirthDate(event.target.value),
                        placeholder: '', // This will remove any placeholder text
                      }}
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
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
                <Grid item xs={12} sm={4}>
                  <TextField
                    label="Stato di Nascita"
                    fullWidth
                    name="birthCountry"
                    value={birthCountry}
                    onChange={(event) => setBirthCountry(event.target.value)}
                    required
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
                  <TextField
                    label="Titolo di Studio"
                    fullWidth
                    name="educationTitle"
                    value={educationTitle}
                    onChange={(event) => setEducationTitle(event.target.value)}
                    required
                  />
                </Grid>
                <Grid item xs={12} sm={4}>
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
                <Grid item xs={12} sm={4}>
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
                        fullWidth
                        style={{ borderRadius: '4px' }}
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

export default AnagraficaSection;