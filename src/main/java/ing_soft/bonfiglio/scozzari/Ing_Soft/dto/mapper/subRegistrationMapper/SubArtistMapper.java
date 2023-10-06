package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Gender;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.StateOfCitizenship;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SubArtistMapper {

    public static Artist artistDTOToArtist(SubArtistDTO subArtistDTO) {
        if (subArtistDTO == null) {
            return null;
        }

        Artist artist = new Artist();

        // Mappa i campi da SubArtistDTO a Artist
        artist.setGender(Gender.valueOf(subArtistDTO.getGender()));
        artist.setBirthDate(subArtistDTO.getBirthDate());
        artist.setBirthPlace(subArtistDTO.getBirthPlace());
        artist.setBirthState(subArtistDTO.getBirthState());
        artist.setEducationTitle(subArtistDTO.getEducationTitle());
        artist.setEuropean(subArtistDTO.isEuropean());
        artist.setStateOfCitizenship(StateOfCitizenship.valueOf(subArtistDTO.getStateOfCitizenship()));
        artist.setCellPhone1(subArtistDTO.getCellPhone1());
        artist.setCellPhone2(subArtistDTO.getCellPhone2());
        artist.setPec(subArtistDTO.getPec());
        artist.setWebsite(subArtistDTO.getWebsite());
        artist.setResidence(subArtistDTO.getResidence());
        artist.setPostalCodeOfResidence(subArtistDTO.getPostalCodeOfResidence());
        artist.setCityOfResidence(subArtistDTO.getCityOfResidence());
        artist.setProvinceOfResidence(subArtistDTO.getProvinceOfResidence());
        artist.setRegionOfResidence(subArtistDTO.getRegionOfResidence());
        artist.setStateOfResidence(subArtistDTO.getStateOfResidence());
        artist.setDomicile(subArtistDTO.getDomicile());
        artist.setPostalCodeOfDomicile(subArtistDTO.getPostalCodeOfDomicile());
        artist.setCityOfDomicile(subArtistDTO.getCityOfDomicile());
        artist.setProvinceOfDomicile(subArtistDTO.getProvinceOfDomicile());
        artist.setRegionOfDomicile(subArtistDTO.getRegionOfDomicile());
        artist.setStateOfDomicile(subArtistDTO.getStateOfDomicile());
        artist.setStageName(subArtistDTO.getStageName());
        artist.setTypologies(subArtistDTO.getIdTypologies());
        artist.setInstrument(subArtistDTO.getInstrument());
        artist.setVoice(subArtistDTO.getVoice());
        artist.setIsIva(subArtistDTO.getIsIva());
        artist.setIva(subArtistDTO.getIva());
        artist.setTaxation(subArtistDTO.getTaxation());
        artist.setIva(subArtistDTO.getIva());
        artist.setOccupation(subArtistDTO.getOccupation());
        artist.setInpsNumber(subArtistDTO.getInpsNumber());
        artist.setMemberFrom(subArtistDTO.getMemberFrom());

        return artist;
    }

    public static SubArtistDTO artistToSubArtistDTO(Artist artist) {
        if (artist == null) {
            return null;
        }

        SubArtistDTO subArtistDTO = new SubArtistDTO();

        // Mappa i campi da Artist a SubArtistDTO
        subArtistDTO.setGender(artist.getGender().name());
        subArtistDTO.setBirthDate(artist.getBirthDate());
        subArtistDTO.setBirthPlace(artist.getBirthPlace());
        subArtistDTO.setBirthState(artist.getBirthState());
        subArtistDTO.setEducationTitle(artist.getEducationTitle());
        subArtistDTO.setEuropean(artist.isEuropean());
        subArtistDTO.setStateOfCitizenship(artist.getStateOfCitizenship().name());
        subArtistDTO.setCellPhone1(artist.getCellPhone1());
        subArtistDTO.setCellPhone2(artist.getCellPhone2());
        subArtistDTO.setPec(artist.getPec());
        subArtistDTO.setWebsite(artist.getWebsite());
        subArtistDTO.setResidence(artist.getResidence());
        subArtistDTO.setPostalCodeOfResidence(artist.getPostalCodeOfResidence());
        subArtistDTO.setCityOfResidence(artist.getCityOfResidence());
        subArtistDTO.setProvinceOfResidence(artist.getProvinceOfResidence());
        subArtistDTO.setRegionOfResidence(artist.getRegionOfResidence());
        subArtistDTO.setStateOfResidence(artist.getStateOfResidence());
        subArtistDTO.setDomicile(artist.getDomicile());
        subArtistDTO.setPostalCodeOfDomicile(artist.getPostalCodeOfDomicile());
        subArtistDTO.setCityOfDomicile(artist.getCityOfDomicile());
        subArtistDTO.setProvinceOfDomicile(artist.getProvinceOfDomicile());
        subArtistDTO.setRegionOfDomicile(artist.getRegionOfDomicile());
        subArtistDTO.setStateOfDomicile(artist.getStateOfDomicile());
        subArtistDTO.setStageName(artist.getStageName());
        subArtistDTO.setIdTypologies(artist.getTypologies());
        subArtistDTO.setInstrument(artist.getInstrument());
        subArtistDTO.setVoice(artist.getVoice());
        subArtistDTO.setIsIva(artist.getIsIva());
        subArtistDTO.setIva(artist.getIva());
        subArtistDTO.setTaxation(artist.getTaxation());
        subArtistDTO.setIva(artist.getIva());
        subArtistDTO.setOccupation(artist.getOccupation());
        subArtistDTO.setInpsNumber(artist.getInpsNumber());
        subArtistDTO.setMemberFrom(artist.getMemberFrom());

        return subArtistDTO;
    }


}
