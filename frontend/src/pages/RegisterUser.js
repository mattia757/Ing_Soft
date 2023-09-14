import React, { useState } from 'react';
import './css/RegisterUser.css'
import { Element, scroller } from 'react-scroll';
import '../configs/colors.css'
import { LinearProgress, Box } from '@mui/material';

import AnagraficaSection from './registration sections/AnagraficaSection';
import CittadinanzaSection from './registration sections/CittadinanzaSection'
import ContattiSection from './registration sections/ContattiSection'
import ResidenzaSection from './registration sections/ResidenzaSection'
import ArtistaSection from './registration sections/ArtistaSection'
import AgenziaSection from './registration sections/AgenziaSection';
import BancaSection from './registration sections/BancaSection';

const RegisterUser = () => {
  const [currentSection, setCurrentSection] = useState(0);
  const totalSections = 5;


  const handleSectionSubmit = () => {
    // Logica di validazione e passaggio alla sezione successiva
    // Esegui la validazione della sezione corrente
    // Se i dati sono validi, passa alla prossima sezione
    if (currentSection < totalSections) {
      const nextSection = currentSection + 1; // Calcola la prossima sezione
      console.log(currentSection, ' ' + nextSection)
      setCurrentSection(nextSection, () => {
        // Esegui lo scroll alla prossima sezione
        scroller.scrollTo(`section${nextSection}`, {
          duration: 500,
          smooth: true,
          offset: -100, // Puoi regolare questo valore per l'offset dello scroll
        });
      });
    }
  };

  const progressPercent = (currentSection / totalSections) * 100;

  return (
    <div>
      <Box display="flex" alignItems="center">
        <LinearProgress
          variant="determinate"
          value={progressPercent}
          sx={{ flexGrow: 1 }}
          style={{ backgroundColor: 'white', height: '1vh', borderRadius: '3px' }}
        />
      </Box>
      {/* Sezione 1 */}
      <Element name="section1">
        {currentSection === 0 && <AnagraficaSection currentSection={currentSection} onSubmit={handleSectionSubmit} />}
      </Element>

      {/* Sezione 2 */}
      <Element name="section2">
        {currentSection === 1 && <CittadinanzaSection currentSection={currentSection} onSubmit={handleSectionSubmit} />}
      </Element>

      {/* Sezione 3 */}
      <Element name="section3">
        {currentSection === 2 && <ContattiSection currentSection={currentSection} onSubmit={handleSectionSubmit} />}
      </Element>

      {/* Sezione 4 */}
      <Element name="section4">
        {currentSection === 3 && <ResidenzaSection currentSection={currentSection} onSubmit={handleSectionSubmit} />}
      </Element>

      {/* Sezione 5 */}
      <Element name="section5">
        {currentSection === 4 && <ArtistaSection currentSection={currentSection} onSubmit={handleSectionSubmit} />}
      </Element>

      {/* Sezione 6 */}
      <Element name="section6">
        {currentSection === 5 && <AgenziaSection currentSection={currentSection} onSubmit={handleSectionSubmit} />}
      </Element>

      {/* Sezione 7 */}
      <Element name="section7">
        {currentSection === 6 && <BancaSection currentSection={currentSection} onSubmit={handleSectionSubmit} />}
      </Element>
    </div>
  );
};

export default RegisterUser;
