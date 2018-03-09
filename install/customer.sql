CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `customer` (`id`, `address`, `contact`, `name`, `phone`) VALUES
(1, '100 Right way', 'CEO', 'Right Inc', '1-800-111-2222'),
(2, 'fsdf', 'asdf', 'adsf', 'asdf'),
(3, 'asdf', 'sdfa', 'adsfaf', 'adsfasfasfasdf');

ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

