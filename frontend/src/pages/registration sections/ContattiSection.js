import React, { useState, useEffect } from 'react';
import { parsePhoneNumberFromString } from 'libphonenumber-js'; //Viene usata per il controllo del numero di telefono

import {
  Button,
  Container,
  Grid,
  Paper,
  TextField,
  Typography,
} from '@mui/material';
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

const ContattiSection = ({ currentSection, onSubmit }) => {
  //Contatti
  const [tel1, setTel1] = useState('');
  const [tel2, setTel2] = useState('');
  const [pec, setPec] = useState('');
  const [website, setWebsite] = useState(''); 

  const [isFormComplete, setIsFormComplete] = useState(false);

    const isEmailValid = (email) => {
    // Regular expression for basic email validation
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailPattern.test(email);
  };


  const isTelValid = (tel1) => {
    const parsedNumber = parsePhoneNumberFromString(tel1, 'ZZ');

    if (parsedNumber && parsedNumber.isValid()) {
      parsedNumber.formatInternational();

      console.log(parsedNumber && parsedNumber.isValid)
      return true;
    }
    else{
      console.log(parsedNumber)
      return false
    }
  }

  const isWebsiteValid = (website) => {
    const websiteRegex = /^(https?:\/\/)?(www\.)?[a-zA-Z0-9-]+\.[a-zA-Z]{2,}(\/\S*)?$/;

    if (!website) {
      return true; // Il campo è vuoto, quindi considerato valido
    }
    else {
      return websiteRegex.test(website)
    }
  }

  useEffect(() => {
    if (
      (tel1 && isTelValid(tel1)) &&
      (!tel2 || isTelValid(tel2)) &&
      (!pec || (isEmailValid(pec))) && 
      (!website || isWebsiteValid(website))
    ) {
      setIsFormComplete(true);
    } else {
      setIsFormComplete(false);
    }
  }, [tel1, tel2, pec, website
]);

  const handleSubmit = (event) => {
    event.preventDefault();

    if (
      (tel1 && isTelValid(tel1)) &&
      (!tel2 || isTelValid(tel2)) &&
      (!pec || (isEmailValid(pec))) && 
      (!website || isWebsiteValid(website))
    ) {
      setIsFormComplete(true);
      const formData = {
        tel1, 
        tel2,
        pec,
        website
      };
      console.log(formData);
      onSubmit();
    } else {
      setIsFormComplete(false);
    }
  };

  return (
    <Container maxWidth="md">
      <StyledPaper>
        <StyledForm onSubmit={handleSubmit}>
          <Grid container spacing={2}>
            <Typography variant="h6" gutterBottom style={{ width: '100%'}}>
              Contatti
            </Typography>
            <Grid item xs={12} sm={6}>
              <TextField
                label="tel1"
                fullWidth
                type="tel"
                name="tel1"
                value={tel1}
                onChange={(event) => setTel1(event.target.value)}
                required
                error={!isTelValid(tel1) && tel1.trim() !== ''}
                helperText={
                  !isTelValid(tel1) && tel1.trim() !== ''
                    ? 'Inserisci un numero di telefono valido, ricordati di inserire il prefisso es. +39'
                    : ''
                }
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                label="tel2"
                fullWidth
                type="tel"
                name="tel2"
                value={tel2}
                onChange={(event) => setTel2(event.target.value)}
                error={!isTelValid(tel2) && tel2.trim() !== ''}
                helperText={
                  !isTelValid(tel2) && tel2.trim() !== ''
                    ? 'Inserisci un numero di telefono valido, ricordati di inserire il prefisso es. +39'
                    : ''
                }
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                label="PEC"
                fullWidth
                type="email"
                name="pec"
                value={pec}
                onChange={(event) => setPec(event.target.value)}
                error={!isEmailValid(pec) && pec.trim() !== ''}
                helperText={
                  !isEmailValid(pec) && pec.trim() !== ''
                    ? 'Inserisci un indirizzo PEC valido'
                    : ''
                }
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                label="Website"
                fullWidth
                name="website"
                value={website}
                onChange={(event) => setWebsite(event.target.value)}
                error={!isWebsiteValid(website)}
                helperText={
                  !isWebsiteValid(website) ? 'Inserisci un sito web valido' : ''
                }
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

export default ContattiSection;