package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubArtistDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Artist;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.Gender;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.enums.StateOfCitizenship;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SubArtistMapper {

    public static Artist mapToArtist(SubArtistDTO subArtistDTO) {
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
        artist.setTypologies(subArtistDTO.getIdTypology());
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

}
