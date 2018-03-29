import { Vehicule } from './vehicule';
import { People } from './people';
import { User } from './user';
import { Photo } from './photo';
import { Weapon } from './weapon';
import { PieceOfEvidence } from './pieceofevidence';

export interface Affaires {
  id?: number;
  name?: string;
  description?: string;
  statusCase?: boolean;
  dateCreation?: Date;
  dateModification?: Date;
  people?: People[];
  user?: User[];
  vehicule?: Vehicule[];
  photo?: Photo[];
  weapon?: Weapon[];
  pieceOfEvidence?: PieceOfEvidence[];


}
