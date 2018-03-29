import { FingerPrint } from './fingerprint';

export interface People {
    id?: number;
    firstName?: string;
    lastName?: string;
    nickName?: string;
    country?: string;
    city?: string;
    region?: string;
    postalZip?: string;
    adress?: string;
    tatoo?: string;
    skinColor?: string;
    eyeColor?: string;
    hairColor?: string;
    hairStyle?: string;
    size?: number;
    weight?: number;
    comment?: string;
    dna?: string;
    status?: string;
    createDate?: Date;
    uptdateDate?: Date;
    fingerPrint?: FingerPrint[];
}
