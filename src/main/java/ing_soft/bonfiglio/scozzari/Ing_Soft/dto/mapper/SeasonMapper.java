package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.SeasonDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Season;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Theater;
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

    public Season seasonDTOToSeason(InputDTO seasonDTO) {
        if ( !(seasonDTO instanceof SeasonDTO seasonData)) {
            return null;
        }

        Season.SeasonBuilder season = Season.builder();

        season.title( seasonData.getTitle() );
        season.startDate( seasonData.getStartDate() );
        season.endDate( seasonData.getEndDate() );
        season.artisticDirectorSocialCosts( seasonData.getArtisticDirectorSocialCosts() );
        season.artisticDirectorCompensation( seasonData.getArtisticDirectorCompensation() );
        season.artisticPersonnelGrossSalary( seasonData.getArtisticPersonnelGrossSalary() );
        season.artisticPersonnelSocialCosts( seasonData.getArtisticPersonnelSocialCosts() );
        season.technicalPersonnelGrossSalary( seasonData.getTechnicalPersonnelGrossSalary() );
        season.technicalPersonnelSocialCosts( seasonData.getTechnicalPersonnelSocialCosts() );
        season.administrativePersonnelGrossSalary( seasonData.getAdministrativePersonnelGrossSalary() );
        season.administrativePersonnelSocialCosts( seasonData.getAdministrativePersonnelSocialCosts() );
        season.artisticPersonnelPerDiem( seasonData.getArtisticPersonnelPerDiem() );
        season.technicalPersonnelPerDiem( seasonData.getTechnicalPersonnelPerDiem() );
        season.projectRelatedDailyExpenses( seasonData.getProjectRelatedDailyExpenses() );
        season.travelTransportAccommodationCosts( seasonData.getTravelTransportAccommodationCosts() );

        return season.build();
    }
}