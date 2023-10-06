package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.SeasonDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Season;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class SeasonMapper {
    public SeasonDTO seasonToSeasonDTO(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonDTO seasonDTO = new SeasonDTO();

        seasonDTO.setIdTheater( season.getId() );
        seasonDTO.setTitle( season.getTitle() );
        seasonDTO.setStartDate( season.getStartDate() );
        seasonDTO.setEndDate( season.getEndDate() );
        seasonDTO.setArtisticDirectorSocialCosts( season.getArtisticDirectorSocialCosts() );
        seasonDTO.setArtisticDirectorCompensation( season.getArtisticDirectorCompensation() );
        seasonDTO.setArtisticPersonnelGrossSalary( season.getArtisticPersonnelGrossSalary() );
        seasonDTO.setArtisticPersonnelSocialCosts( season.getArtisticPersonnelSocialCosts() );
        seasonDTO.setTechnicalPersonnelGrossSalary( season.getTechnicalPersonnelGrossSalary() );
        seasonDTO.setTechnicalPersonnelSocialCosts( season.getTechnicalPersonnelSocialCosts() );
        seasonDTO.setAdministrativePersonnelGrossSalary( season.getAdministrativePersonnelGrossSalary() );
        seasonDTO.setAdministrativePersonnelSocialCosts( season.getAdministrativePersonnelSocialCosts() );
        seasonDTO.setArtisticPersonnelPerDiem( season.getArtisticPersonnelPerDiem() );
        seasonDTO.setTechnicalPersonnelPerDiem( season.getTechnicalPersonnelPerDiem() );
        seasonDTO.setProjectRelatedDailyExpenses( season.getProjectRelatedDailyExpenses() );
        seasonDTO.setTravelTransportAccommodationCosts( season.getTravelTransportAccommodationCosts() );

        return seasonDTO;
    }

    public Season seasonDTOToSeason(SeasonDTO seasonDTO) {
        if ( seasonDTO == null ) {
            return null;
        }

        Season.SeasonBuilder season = Season.builder();

        season.id( seasonDTO.getIdTheater() );
        season.title( seasonDTO.getTitle() );
        season.startDate( seasonDTO.getStartDate() );
        season.endDate( seasonDTO.getEndDate() );
        season.artisticDirectorSocialCosts( seasonDTO.getArtisticDirectorSocialCosts() );
        season.artisticDirectorCompensation( seasonDTO.getArtisticDirectorCompensation() );
        season.artisticPersonnelGrossSalary( seasonDTO.getArtisticPersonnelGrossSalary() );
        season.artisticPersonnelSocialCosts( seasonDTO.getArtisticPersonnelSocialCosts() );
        season.technicalPersonnelGrossSalary( seasonDTO.getTechnicalPersonnelGrossSalary() );
        season.technicalPersonnelSocialCosts( seasonDTO.getTechnicalPersonnelSocialCosts() );
        season.administrativePersonnelGrossSalary( seasonDTO.getAdministrativePersonnelGrossSalary() );
        season.administrativePersonnelSocialCosts( seasonDTO.getAdministrativePersonnelSocialCosts() );
        season.artisticPersonnelPerDiem( seasonDTO.getArtisticPersonnelPerDiem() );
        season.technicalPersonnelPerDiem( seasonDTO.getTechnicalPersonnelPerDiem() );
        season.projectRelatedDailyExpenses( seasonDTO.getProjectRelatedDailyExpenses() );
        season.travelTransportAccommodationCosts( seasonDTO.getTravelTransportAccommodationCosts() );

        return season.build();
    }
}