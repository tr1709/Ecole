-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 11 jan. 2022 à 17:57
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `profs`
--

CREATE TABLE `profs` (
  `id` int(11) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `profs`
--

INSERT INTO `profs` (`id`, `date_naissance`, `nom`, `prenom`, `sexe`) VALUES
(1, '1978-03-19', 'Janssens', 'Anne', 'F'),
(2, '1973-11-21', 'Novak', 'Steve', 'H'),
(3, '1982-04-08', 'Anderson', 'Betty', 'F'),
(4, '1970-07-15', 'Jacobs', 'Marc', 'H');

-- --------------------------------------------------------

--
-- Structure de la table `seancescours`
--

CREATE TABLE `seancescours` (
  `id` int(11) NOT NULL,
  `heure_debut` time NOT NULL,
  `heure_fin` time NOT NULL,
  `jour` varchar(255) NOT NULL,
  `nom_cours` varchar(255) DEFAULT NULL,
  `prof_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seancescours`
--

INSERT INTO `seancescours` (`id`, `heure_debut`, `heure_fin`, `jour`, `nom_cours`, `prof_id`) VALUES
(1, '09:15:00', '12:15:00', 'Lundi', 'Mathematique', 4),
(2, '08:30:00', '12:30:00', 'Mardi', 'Programmation', 1),
(3, '13:00:00', '15:30:00', 'Mercredi', 'Statistique', 4);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `profs`
--
ALTER TABLE `profs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `seancescours`
--
ALTER TABLE `seancescours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhqgwn480h73tcl8q7fgb8hs1n` (`prof_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `profs`
--
ALTER TABLE `profs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `seancescours`
--
ALTER TABLE `seancescours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `seancescours`
--
ALTER TABLE `seancescours`
  ADD CONSTRAINT `FKhqgwn480h73tcl8q7fgb8hs1n` FOREIGN KEY (`prof_id`) REFERENCES `profs` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
