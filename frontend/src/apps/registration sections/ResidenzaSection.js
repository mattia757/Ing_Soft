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

const ResidenzaSection = ({ currentSection, onSubmit }) => {
  //Residenza
  const [residenza, setResidenza] = useState('');
  const [cap, setCap] = useState('');
  const [cittàResidenza, setCittàResidenza] = useState('');
  const [provinciaResidenza, setProvinciaResidenza] = useState('');
  const [regioneResidenza, setRegioneResidenza] = useState('');
  const [stateResidence, setStateResidence] = useState('');
  const [stateResidenceOpen, setStateResidenceOpen] = useState(false); //Variabile che fa aprire la Select degli Stati per la residenza

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
    'Cuba',
    'Dominica',
    'Ecuador',
    'Egitto',
    'El Salvador',
    'Emirati Arabi Uniti',
    'Eritrea',
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
  const countries = euCountries.concat(nonEuCountries)
  
  const [isFormComplete, setIsFormComplete] = useState(false);

  const isNameValid = (name) => {
    const namePattern = /^[a-zA-Z\s]*$/;
    return namePattern.test(name)
  };

  const isAddressValid = (residenza) => {
    const residenzaPattern = /^[a-zA-Z0-9\- ]+$/;
    
    return residenzaPattern.test(residenza)
  };

  useEffect(() => {
    if (
      residenza &&
      cap &&
      cittàResidenza &&
      provinciaResidenza &&
      regioneResidenza &&
      stateResidence
    ) {
      setIsFormComplete(true);
    } else {
      setIsFormComplete(false);
    }
  }, [residenza, cap, cittàResidenza, provinciaResidenza, regioneResidenza, stateResidence
]);


  const handleSubmit = (event) => {
    event.preventDefault();

    if (
      residenza &&
      cap &&
      cittàResidenza &&
      provinciaResidenza &&
      regioneResidenza &&
      stateResidence
    ) {
      setIsFormComplete(true);
      const formData = {
        residenza,
        cap,
        cittàResidenza,
        provinciaResidenza,
        regioneResidenza,
        stateResidence
      };
      console.log(formData);
      onSubmit();
    } else {
      setIsFormComplete(false);
    }
  };

  //Close Stato Residenza
  const handleResidenceStateClose = () => {
    setStateResidenceOpen(false);
  };
  
  //Open Stato Residenza
  const handleResidenceStateOpen = () => {
    setStateResidenceOpen(true);
  };

  return (
    <Container maxWidth="md">
      <StyledPaper>
        <StyledForm onSubmit={handleSubmit}>
          <Grid container spacing={2}>
            <Typography variant="h6" gutterBottom style={{ width: '100%'}}>
              Residenza
            </Typography>
            <Grid item xs={12} sm={4}>
              <TextField
                label="Residenza"
                fullWidth
                name="residenza"
                value={residenza}
                onChange={(event) => setResidenza(event.target.value)}
                required
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                label="Cap Residenza"
                fullWidth
                name="cap"
                value={cap}
                onChange={(event) => setCap(event.target.value)}
                required
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                label="Città Residenza"
                fullWidth
                name="cittàResidenza"
                value={cittàResidenza}
                onChange={(event) => setCittàResidenza(event.target.value)}
                required
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                label="Provincia Residenza"
                fullWidth
                name="provinciaResidenza"
                value={provinciaResidenza}
                onChange={(event) => setProvinciaResidenza(event.target.value)}
                required
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                label="Regione Residenza"
                fullWidth
                name="regioneResidenza"
                value={regioneResidenza}
                onChange={(event) => setRegioneResidenza(event.target.value)}
                required
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <FormControl sx={{ m: 1, minWidth: '13.7rem' }} style={{ margin: 'auto' }}>
                <InputLabel id="state-residence-label">Stato di residenza</InputLabel>
                <Select
                  labelId="state-residence-label"
                  id="state-residence-label"
                  open={stateResidenceOpen}
                  onClose={handleResidenceStateClose}
                  onOpen={handleResidenceStateOpen}
                  name="stateResidence"
                  value={stateResidence}
                  label={'Stato Residenza'}
                  onChange={(event) => setStateResidence(event.target.value)}
                  required
                >
                {countries.map((country) => (
                  <MenuItem key={country} value={country}>
                    {country}
                  </MenuItem>
                ))}
                </Select>
              </FormControl>
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

export default ResidenzaSection;