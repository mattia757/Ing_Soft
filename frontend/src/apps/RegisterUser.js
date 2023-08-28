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
import { width } from '@mui/system';

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

function RegistrationForm() {
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

  //Cittadinanza
  const [euCitizen, setEuCitizen] = useState(false);
  const [euCountryOpen, setEuCountryOpen] = useState(false);
  const [nonEuCountryOpen, setNonEuCountryOpen] = useState(false);
  const [euCountry, setEuCountry] = useState(false);
  const [nonEuCountry, setNonEuCountry] = useState(false);
  const [euCitizenOpen, setEuCitizenOpen] = useState(false);

  const euCountries = [
    'Austria',
    'Belgio',
    'Bulgaria',
    'Cipro',
    'Croazia',
    'Danimarca',
    'Estonia',
    'Finlandia',
    'Francia',
    'Germania',
    'Grecia',
    'Irlanda',
    'Italia',
    'Lettonia',
    'Lituania',
    'Lussemburgo',
    'Malta',
    'Paesi Bassi',
    'Polonia',
    'Portogallo',
    'Repubblica Ceca',
    'Romania',
    'Slovacchia',
    'Slovenia',
    'Spagna',
    'Svezia',
    'Ungheria'
  ];
  const nonEuCountries = [
    'Afghanistan',
    'Albania',
    'Algeria',
    'Andorra',
    'Angola',
    'Antigua e Barbuda',
    'Arabia Saudita',
    'Argentina',
    'Armenia',
    'Australia',
    'Azerbaijan',
    'Bahamas',
    'Bahrain',
    'Bangladesh',
    'Barbados',
    'Belize',
    'Benin',
    'Bhutan',
    'Bielorussia',
    'Birmania (Myanmar)',
    'Bolivia',
    'Bosnia ed Erzegovina',
    'Botswana',
    'Brasile',
    'Brunei',
    'Burkina Faso',
    'Burundi',
    'Cambogia',
    'Camerun',
    'Canada',
    'Capo Verde',
    'Ciad',
    'Cile',
    'Cina',
    'Colombia',
    'Comore',
    'Congo',
    'Corea del Nord',
    'Corea del Sud',
    'Costa d\'Avorio',
    'Costa Rica',
    'Croazia',
    'Cuba',
    'Danimarca',
    'Dominica',
    'Ecuador',
    'Egitto',
    'El Salvador',
    'Emirati Arabi Uniti',
    'Eritrea',
    'Estonia',
    'Etiopia',
    'Figi',
    'Filippine',
    'Gabon',
    'Gambia',
    'Georgia',
    'Ghana',
    'Giamaica',
    'Giappone',
    'Gibuti',
    'Giordania',
    'Grenada',
    'Guatemala',
    'Guinea',
    'Guinea Equatoriale',
    'Guinea-Bissau',
    'Guyana',
    'Haiti',
    'Honduras',
    'India',
    'Indonesia',
    'Iran',
    'Iraq',
    'Islanda',
    'Israele',
    'Kazakistan',
    'Kenya',
    'Kirghizistan',
    'Kiribati',
    'Kosovo',
    'Kuwait',
    'Laos',
    'Lesotho',
    'Libano',
    'Liberia',
    'Libia',
    'Liechtenstein',
    'Macedonia del Nord',
    'Madagascar',
    'Malawi',
    'Malaysia',
    'Maldive',
    'Mali',
    'Marocco',
    'Mauritania',
    'Mauritius',
    'Messico',
    'Micronesia',
    'Moldavia',
    'Monaco',
    'Mongolia',
    'Montenegro',
    'Mozambico',
    'Namibia',
    'Nauru',
    'Nepal',
    'Nicaragua',
    'Niger',
    'Nigeria',
    'Norvegia',
    'Nuova Zelanda',
    'Oman',
    'Pakistan',
    'Palau',
    'Panama',
    'Papua Nuova Guinea',
    'Paraguay',
    'Perù',
    'Qatar',
    'Regno Unito',
    'Repubblica Democratica del Congo',
    'Repubblica Dominicana',
    'Ruanda',
    'Russia',
    'Saint Kitts e Nevis',
    'Saint Lucia',
    'Saint Vincent e Grenadine',
    'Samoa',
    'San Marino',
    'Sao Tomé e Principe',
    'Senegal',
    'Serbia',
    'Seychelles',
    'Sierra Leone',
    'Singapore',
    'Siria',
    'Somalia',
    'Sri Lanka',
    'Sudafrica',
    'Sudan',
    'Sudan del Sud',
    'Suriname',
    'Swaziland',
    'Tagikistan',
    'Tanzania',
    'Thailandia',
    'Timor Est',
    'Togo',
    'Tonga',
    'Trinidad e Tobago',
    'Tunisia',
    'Turchia',
    'Turkmenistan',
    'Tuvalu',
    'Ucraina',
    'Uganda',
    'Uruguay',
    'Uzbekistan',
    'Vanuatu',
    'Venezuela',
    'Vietnam',
    'Yemen',
    'Zambia',
    'Zimbabwe'
  ];
  

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
      isEmailValid(email) &&
      typeof isStudent === 'boolean'
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

  //Close Select Gender
  const handleClose = () => {
    setOpen(false);
  };

  //Open Select Gender
  const handleOpen = () => {
    setOpen(true);
  };

  // Funzione per gestire l'apertura della select EU Citizen
  const handleEuCitizenOpen = () => {
    setEuCitizenOpen(true);
  };

  // Funzione per gestire la chiusura della select EU Citizen
  const handleEuCitizenClose = () => {
    setEuCitizenOpen(false);
  };

  //Close Eu Country
  const handleEuCountryClose = () => {
    setEuCountryOpen(false);
  };

  //Open Eu Country
  const handleEuCountryOpen = () => {
    setEuCountryOpen(true);
  };

  //Close Non Eu Country
  const handleNonEuCountryClose = () => {
    setNonEuCountryOpen(false);
  };
  
  //Open Non Eu Country
  const handleNonEuCountryOpen = () => {
    setNonEuCountryOpen(true);
  };

  return (
    <Container maxWidth="md">
      <StyledPaper>
        <Typography variant="h4" align='center' gutterBottom>
          Dati anagrafici
        </Typography>
        <Typography variant="h6" gutterBottom>
          Dati personali
        </Typography>
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
              <FormControl sx={{ m: 1, minWidth: '13.7rem' }} style={{ margin: 'auto' }}>
              <InputLabel id="demo-controlled-open-select-label" >
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
            </Grid>
            <Grid item xs={12} sm={4}>
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
                  onChange: (event) => setBirthDate(event.target.value),
                }}
                required
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
            <Typography variant="h6" gutterBottom style={{ width: '100%' }}>
              Cittadinanza
            </Typography>
            <Grid item xs={12} sm={4}>
              <FormControl sx={{ m: 1, minWidth: '13.7rem' }} style={{ margin: 'auto' }}>
                <InputLabel id="eu-citizen-label">Appartiene alla Comunità Europea?</InputLabel>
                <Select
                  labelId="eu-citizen-label"
                  id="eu-citizen-select"
                  open={euCitizenOpen}
                  onClose={handleEuCitizenClose}
                  onOpen={handleEuCitizenOpen}
                  name="euCitizen"
                  value={euCitizen}
                  label={'Appartiene alla Comunità Europea?'}
                  onChange={(event) => setEuCitizen(event.target.value)}
                  required
                >
                  <MenuItem value={'Si'}>Si</MenuItem>
                  <MenuItem value={'No'}>No</MenuItem>
                </Select>
              </FormControl>
            </Grid>
            {euCitizen === 'Si' && (
              <Grid item xs={12} sm={4}>
                <FormControl sx={{ m: 1, minWidth: 120 }} style={{ margin: 'auto' }}>
                  <InputLabel id="eu-country-label">Stato dell'Unione Europea</InputLabel>
                  <Select
                    labelId="eu-country-label"
                    id="eu-country-select"
                    open={euCountryOpen}
                    onClose={handleEuCountryClose}
                    onOpen={handleEuCountryOpen}
                    name="euCountry"
                    value={euCountry}
                    label={"Stato dell'Unione Europea"}
                    onChange={(event) => setEuCountry(event.target.value)}
                    required
                  >
                    {euCountries.map((country) => (
                      <MenuItem key={country} value={country}>
                        {country}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </Grid>
            )}
            {euCitizen === 'No' && (
              <Grid item xs={12} sm={4}>
                <FormControl sx={{ m: 1, minWidth: 120 }} style={{ margin: 'auto' }}>
                  <InputLabel id="eu-country-label">Stato fuori dall'Unione Europea</InputLabel>
                    <Select
                      id="eu-non-country-select"
                      open={nonEuCountryOpen}
                      onClose={handleNonEuCountryClose}
                      onOpen={handleNonEuCountryOpen}
                      value={nonEuCountry}
                      label="Stato fuori dall'Unione Europea"
                      fullWidth
                      name="nonEuCountry"
                      onChange={(event) => setNonEuCountry(event.target.value)}
                      required
                    >
                      {nonEuCountries.map((country) => (
                        <MenuItem key={country} value={country}>
                          {country}
                        </MenuItem>
                      ))}
                    </Select>
                </FormControl> 
              </Grid>
            )}
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

export default RegistrationForm;
